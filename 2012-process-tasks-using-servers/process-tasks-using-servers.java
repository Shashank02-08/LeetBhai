class Solution {
    static class Pair {
        int server, weight;
        long time;

        Pair(int server, int weight) {
            this.server = server;
            this.weight = weight;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        // Available servers: minimum weight, then minimum index.
        PriorityQueue<Pair> availableServers = new PriorityQueue<>((a, b) -> {
            if (a.weight == b.weight)
                return Integer.compare(a.server, b.server);
            return Integer.compare(a.weight, b.weight);
        });

        // Busy servers: earliest completion time first.
        PriorityQueue<Pair> busyServers = new PriorityQueue<>(
            (a, b) -> Long.compare(a.time, b.time)
        );

        for (int i = 0; i < n; i++) {
            availableServers.offer(new Pair(i, servers[i]));
        }

        long currentTime = 0;

        for (int i = 0; i < m; i++) {
            currentTime = Math.max(currentTime, i);

            // Release all servers that have completed their tasks.
            while (!busyServers.isEmpty() &&
                   busyServers.peek().time <= currentTime) {

                Pair server = busyServers.poll();
                availableServers.offer(server);
            }

            // If all servers are busy, jump to the earliest
            // server completion time.
            if (availableServers.isEmpty()) {
                currentTime = busyServers.peek().time;

                // Release all servers completing at this time.
                while (!busyServers.isEmpty() &&
                       busyServers.peek().time <= currentTime) {

                    Pair server = busyServers.poll();
                    availableServers.offer(server);
                }
            }

            // Assign the task to the best available server.
            Pair server = availableServers.poll();

            ans[i] = server.server;

            server.time = currentTime + tasks[i];

            busyServers.offer(server);
        }

        return ans;
    }
}