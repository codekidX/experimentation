from collections import defaultdict, deque


class Graph(object):
    def __init__(self):
        self.nodes = set()     #set containing tuples
        self.edges = defaultdict(list)     #dictionary
        self.distances = {}     #array

    def add_node(self, value):
        self.nodes.add(value)  #add the values

    def add_edge(self, from_node, to_node, distance):
        self.edges[from_node].append(to_node)
        self.edges[to_node].append(from_node)
        self.distances[(from_node, to_node)] = distance


def dijkstra(graph, initial):
    visited = {initial: 0}
    path = {}

    nodes = set(graph.nodes)

    while nodes:
        min_node = None
        for node in nodes:
            if node in visited:
                if min_node is None:
                    min_node = node
                elif visited[node] < visited[min_node]:
                    min_node = node
        if min_node is None:
            break

        nodes.remove(min_node)
        current_weight = visited[min_node]

        for edge in graph.edges[min_node]:
            try:
                weight = current_weight + graph.distances[(min_node, edge)]
            except:
                continue
            if edge not in visited or weight < visited[edge]:
                visited[edge] = weight
                path[edge] = min_node

    return visited, path

def execute_dijkstras(graph):
	exit_sequence = True

	while exit_sequence is True:

		user_input = raw_input(' Add edge ? \n\n TYPE: \n\n done to exit\n ENTER to add\n default to use default graph \n\n : ')

		if user_input == "done":
			# after added all paths, nodes blah blah
			start_from = raw_input("what's your source ? : ")
			where_to_go = raw_input("what's your destination ? : ")
			print(shortest_path(graph, start_from, where_to_go))
			exit_sequence = False
		elif user_input =="default":
			graph.add_edge('A', 'B', 10)
			graph.add_edge('A', 'C', 20)
			graph.add_edge('B', 'D', 15)
			graph.add_edge('C', 'D', 30)
			graph.add_edge('B', 'E', 50)
			graph.add_edge('D', 'E', 30)
			graph.add_edge('E', 'F', 5)
			graph.add_edge('F', 'G', 2)

			# after added all paths, nodes blah blah
			start_from = raw_input("what's your source ? : ")
			where_to_go = raw_input("what's your destination ? : ")
			print(shortest_path(graph, start_from, where_to_go))
			exit_sequence = False

		else:
			add_from_node = raw_input('Add source: ')
			add_to_node = raw_input('Add destination: ')
			add_node_distance = int(raw_input('Add distance: '))

			graph.add_edge(add_from_node, add_to_node, add_node_distance)



def shortest_path(graph, origin, destination):
    visited, paths = dijkstra(graph, origin)
    full_path = deque()
    _destination = paths[destination]

    while _destination != origin:
        full_path.appendleft(_destination)
        _destination = paths[_destination]

    full_path.appendleft(origin)
    full_path.append(destination)

    return visited[destination], list(full_path)

if __name__ == '__main__':
    graph = Graph()

    for node in ['A', 'B', 'C', 'D', 'E', 'F', 'G']:
        graph.add_node(node)

    execute_dijkstras(graph) 