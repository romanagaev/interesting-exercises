'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');
    main();
});

function readLine() {
    return inputString[currentLine++];
}

// MinPriorityQueue with same interface
class MinPriorityQueue {
    constructor({ priority }) {
        this.heap = [];
        this.priority = priority;
    }

    enqueue(value) {
        this.heap.push(value);
        this.#bubbleUp(this.heap.length - 1);
    }

    dequeue() {
        if (this.isEmpty()) return null;
        const min = this.heap[0];
        const end = this.heap.pop();
        if (!this.isEmpty()) {
            this.heap[0] = end;
            this.#sinkDown(0);
        }
        return { element: min };
    }

    isEmpty() {
        return this.heap.length === 0;
    }

    #bubbleUp(index) {
        const element = this.heap[index];
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            const parent = this.heap[parentIndex];
            if (this.priority(element) >= this.priority(parent)) break;
            this.heap[index] = parent;
            index = parentIndex;
        }
        this.heap[index] = element;
    }

    #sinkDown(index) {
        const length = this.heap.length;
        const element = this.heap[index];
        const elementPriority = this.priority(element);

        while (true) {
            let leftIdx = 2 * index + 1;
            let rightIdx = 2 * index + 2;
            let swap = null;

            if (leftIdx < length && this.priority(this.heap[leftIdx]) < elementPriority) {
                swap = leftIdx;
            }

            if (
                rightIdx < length &&
                this.priority(this.heap[rightIdx]) < (swap === null ? elementPriority : this.priority(this.heap[swap]))
            ) {
                swap = rightIdx;
            }

            if (swap === null) break;

            this.heap[index] = this.heap[swap];
            index = swap;
        }

        this.heap[index] = element;
    }
}

function dijkstra(start, adjList, n) {
    const distances = Array(n + 1).fill(Infinity);
    const visited = Array(n + 1).fill(false);
    const pq = new MinPriorityQueue({ priority: x => x[1] });

    distances[start] = 0;
    pq.enqueue([start, 0]);

    while (!pq.isEmpty()) {
        const [u, d] = pq.dequeue().element;
        if (visited[u]) continue;
        visited[u] = true;

        for (const [v, w] of adjList[u]) {
            if (!visited[v] && distances[u] + w < distances[v]) {
                distances[v] = distances[u] + w;
                pq.enqueue([v, distances[v]]);
            }
        }
    }

    return distances;
}

function main() {
    const [n, m] = readLine().split(' ').map(Number);

    // Use a map of maps to store the latest weight
    const edgeMap = Array.from({ length: n + 1 }, () => new Map());

    for (let i = 0; i < m; i++) {
        const [u, v, w] = readLine().split(' ').map(Number);
        edgeMap[u].set(v, w); // overwrite if multiple edges from u to v
    }

    // Convert map into adjacency list
    const adjList = Array.from({ length: n + 1 }, () => []);
    for (let u = 1; u <= n; u++) {
        for (const [v, w] of edgeMap[u]) {
            adjList[u].push([v, w]);
        }
    }

    const q = parseInt(readLine());
    const queries = [];
    const fromSet = new Set();

    for (let i = 0; i < q; i++) {
        const [x, y] = readLine().split(' ').map(Number);
        queries.push([x, y]);
        fromSet.add(x);
    }

    // Run Dijkstra only once per unique start node
    const allDistances = {};
    for (const from of fromSet) {
        allDistances[from] = dijkstra(from, adjList, n);
    }

    for (const [x, y] of queries) {
        const dist = allDistances[x][y];
        console.log(dist === Infinity ? -1 : dist);
    }
}
