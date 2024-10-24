import dsa.others.LexicalOrderWord;
import dsa.shortest_path.dijkstra.Dijkstra;
import dsa.shortest_path.dijkstra.Graph;
import dsa.trees.AVL.AVLTree;
import dsa.trees.AVL.NodeAVL;
import dsa.trees.BST.BinarySearchTree;
import dsa.trees.BST.Node;
import leetcode_problems.arrays_and_hashing.contains_duplicate.ContainsDuplicate;
import leetcode_problems.arrays_and_hashing.group_anagrams.GroupAnagrams;
import leetcode_problems.arrays_and_hashing.longest_consecutive_sequence.LongestConsecutiveSequence;
import leetcode_problems.arrays_and_hashing.product_of_array_except_self.ProductOfArrayExceptSelf;
import leetcode_problems.arrays_and_hashing.string_encode_and_decode.StringEncodeAndDecode;
import leetcode_problems.arrays_and_hashing.top_k_frequent_elements.TopKFrequentElements;
import leetcode_problems.arrays_and_hashing.two_sum.TwoSum;
import leetcode_problems.arrays_and_hashing.valid_anagram.ValidAnagram;
import leetcode_problems.arrays_and_hashing.valid_sudoku.ValidSudoku;
import leetcode_problems.stack.generate_parentheses.GenerateParentheses;
import leetcode_problems.stack.reverse_polish_notation.RPN;
import leetcode_problems.stack.valid_parentheses.ValidParentheses;
import leetcode_problems.two_pointers.container_with_most_water.ContainerWithMostWater;
import leetcode_problems.two_pointers.three_sum.ThreeSum;
import leetcode_problems.two_pointers.trapping_rain_water.TrappingRainWater;
import leetcode_problems.two_pointers.two_sum_array_sorted.TwoSumArraySorted;
import leetcode_problems.two_pointers.valid_palindrome.ValidPalindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dsa.searching_algorithms.BreadthFirstSearch.addEdge;
import static dsa.searching_algorithms.BreadthFirstSearch.bfs;
import static dsa.searching_algorithms.DepthFirstSearch.DFS;
import static dsa.searching_algorithms.DepthFirstSearch.addEdgeDFS;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Node nodeA;

    public static void main(String[] args) {
        //==============================================================================================================
        // SORTING ALGORITHMS
        //int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        //int[] array = {3, 7, 8, 5, 4, 2, 6, 1};
        int[] array = {2, 4, 1, 3, 8, 7, 9, 6, 5};
        //System.out.println(Arrays.toString(BubbleSort.bubbleSortMethod(array)));
        //System.out.println(Arrays.toString(InsertionSort.insertionSortMethod(array)));
        //System.out.println(Arrays.toString(SelectionSort.selectionSortMethod(array)));
        //MergeSort.mergeSort(array);
        //Draft.mergeSort(array);
        //QuickSort.quickSort(array, 0, array.length - 1);
        //HeapSort.sort(array);
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();

        //==============================================================================================================


        //ARRAYS AND HASHING
        //==============================================================================================================
        //Contains duplicate problem
        int[] tab = {1, 2, 3, 4, 5, 1};
        boolean result = ContainsDuplicate.containsDuplicate(tab);
        boolean result2 = ContainsDuplicate.containsDuplicateMoreOptimally(tab);
        System.out.println("contains duplicate problem, solution 1: " + result);
        System.out.println("contains duplicate problem, solution 2: " + result2);

        //Valid anagram problem
        String s = "anagram";
        String t = "nagaram";
        boolean validAnagramResult = ValidAnagram.validAnagramMethod(s, t);
        boolean validAnagramResult2 = ValidAnagram.isAnagram(s, t);
        System.out.println("valid anagram problem, solution 2: " + validAnagramResult2);

        //two sum problem
        int[] nums = {15, 11, 2, 7};
        int target = 9;
        int[] twoSumResult = TwoSum.twoSum(nums, target);
        int[] twoSumResultMoreOptimal = TwoSum.twoSumMoreOptimalVersion(nums, target);

        //group anagrams problem
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagrams = GroupAnagrams.groupAnagramsMethod(strs);

        //top k frequent elements
        int[] frequentElementsTab = {1, 1, 1, 2, 2, 3, 3, 3, 3, 3};
        int k = 2;
        int[] finalFrequentElementsTab = TopKFrequentElements.topKFrequent(frequentElementsTab, k);

        //product of array except self problem
        int[] nums2 = {1, 2, 3, 4}; //{1,1,2,6}
        int[] nums3 = {-1, 1, 0, -3, 3};
        int[] resultProductOfArrayExceptSelf = ProductOfArrayExceptSelf.productExceptSelfMoreOptimal(nums2);
        System.out.println(Arrays.toString(resultProductOfArrayExceptSelf));
        int[] resultProductOfArrayExceptSelf2 = ProductOfArrayExceptSelf.productExceptSelfBestApproach(nums2);
        System.out.println(Arrays.toString(resultProductOfArrayExceptSelf2));

        //valid sudoku problem
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(ValidSudoku.isValidSudoku(board));
        System.out.println(ValidSudoku.isValidSudokuMoreOptimal(board));

        //longest consecutive sequence problem
        int[] consecutiveTab = {4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3};
        System.out.println(LongestConsecutiveSequence.longestConsecutive(consecutiveTab));

        //string encode and decode problem
        List<String> encodeList = List.of(new String[]{"neet", "code", "love", "you"});
        String encodeString = StringEncodeAndDecode.encode(encodeList);
        List<String> decodeList = StringEncodeAndDecode.decode(encodeString);
        System.out.println(decodeList);
        //==============================================================================================================
        //TWO POINTERS
        //==============================================================================================================
        //valid palindrome problem
        String validPalindrome = "A man, a plan, a canal: Panama";
        boolean validPalindromeResult = ValidPalindrome.isPalindrome(validPalindrome);
        System.out.println("Valid palindrome result: " + validPalindromeResult);
        boolean validPalindromeSecondVersion = ValidPalindrome.isAnagramTwoPointers(validPalindrome);
        System.out.println("Valid palindrome result, version 2: " + validPalindromeSecondVersion);

        //Two Sum II - Input Array Is Sorted
        int[] twoSum = {2, 7, 11, 15};
        int targetTwoSum = 9;
        int[] twoSum2Result = TwoSumArraySorted.twoSum(twoSum, targetTwoSum);
        System.out.println(Arrays.toString(twoSum2Result));
        //3sum
        int[] threeSumTab = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSumResult = ThreeSum.threeSum_2(threeSumTab);
        //container with most water
        int[] waterContainer = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] waterContainer2 = {1, 1};
        //int maxWaterContainer = ContainerWithMostWater.maxArea(waterContainer);
        int maxWaterContainer = ContainerWithMostWater.maxArea_2(waterContainer);
        System.out.println("max water container: " + maxWaterContainer);
        //trapping rain water
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trappingRainWaterResult = TrappingRainWater.trap(height);
        System.out.println(trappingRainWaterResult);

        //==============================================================================================================
        //STACK
        //==============================================================================================================
        //valid parentheses
        String validParentheses = "{[]}";
        System.out.println(ValidParentheses.isValidFirstApproach(validParentheses));
        System.out.println(ValidParentheses.isValidSecondApproach(validParentheses));
        //min leetcode_problems.stack
        //...
        //evaluate reverse polish notation
        String[] tokens = {"2", "1", "+", "3", "*"};
        int rpnResult = RPN.evalRPN(tokens);
        System.out.println(rpnResult);
        //generate parentheses
        int n = 3;
        System.out.println(GenerateParentheses.generateParenthesis(n));


        //======================== bst tree
        //Binary Search Tree = A tree data structure, where each node is greater than it's left child,
        //		                         but less than it's right.

        //					   benefit: easy to locate a node when they are in this order

        //					   time complexity: best case  O(log n)
        //									 worst case O(n)

        //					   space complexity: O(n)

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(9));
        tree.insert(new Node(2));
        tree.insert(new Node(7));
        tree.insert(new Node(3));
        tree.insert(new Node(6));
        tree.insert(new Node(4));
        tree.insert(new Node(8));

        //tree.remove(1);
        tree.display();
        System.out.println("\n");
        tree.inorderTraversal(tree.getRoot());
        System.out.println("\n");
        tree.postorderTraversal(tree.getRoot());
        System.out.println("\n");
        tree.preorderTraversal(tree.getRoot());
        System.out.println("\n");


        // Create an instance of AVLTree
        AVLTree avlTree = new AVLTree();

        // Insert elements into the AVL tree
        System.out.println("Inserting elements: 10, 20, 30, 40, 50, 25");
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);

        // Print the root and height of the tree
        System.out.println("Root of AVL Tree: " + avlTree.getRoot().getKey());
        System.out.println("Height of AVL Tree: " + avlTree.height());

        // Find elements in the AVL tree
        int keyToFind = 30;
        NodeAVL foundNode = avlTree.find(keyToFind);
        System.out.println("Finding element " + keyToFind + ": " + (foundNode != null ? "Found" : "Not Found"));

        keyToFind = 60;
        foundNode = avlTree.find(keyToFind);
        System.out.println("Finding element " + keyToFind + ": " + (foundNode != null ? "Found" : "Not Found"));

        // Delete an element from the AVL tree
        int keyToDelete = 50;
        System.out.println("Deleting element " + keyToDelete);
        avlTree.delete(keyToDelete);

        // Print the root and height of the tree after deletion
        System.out.println("Root of AVL Tree after deletion: " + avlTree.getRoot().getKey());
        System.out.println("Height of AVL Tree after deletion: " + avlTree.height());

        // Find the deleted element to ensure it was removed
        foundNode = avlTree.find(keyToDelete);
        System.out.println("Finding deleted element " + keyToDelete + ": " + (foundNode != null ? "Found" : "Not Found"));

        //----------
        System.out.println("\n");
        String w = LexicalOrderWord.getSmallestWordLexicographicallyLargerThanGiven("abdc");
        System.out.println(w);
        System.out.println();

        //BFS
        // Number of vertices in the graph
        int V = 5;

        // Adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        // Perform BFS traversal starting from vertex 0
        System.out.println("BFS starting from 0 : ");
        bfs(adj, 0, visited);

        //DFS
        System.out.println("\n\n");
        int VDfs = 5; // Number of vertices in the graph

        // Create an adjacency list for the graph
        List<List<Integer> > adjDFS = new ArrayList<>(V);
        for (int i = 0; i < VDfs; i++) {
            adjDFS.add(new ArrayList<>());
        }

        // Define the edges of the graph
        int[][] edges = {
                { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 }
        };

        // Populate the adjacency list with edges
        for (int[] e : edges) {
            addEdgeDFS(adjDFS, e[0], e[1]);
        }

        int source = 1;
        System.out.println("DFS from source: " + source);
        DFS(adjDFS, source);
        System.out.println();

        dsa.shortest_path.dijkstra.Node nodeA = new dsa.shortest_path.dijkstra.Node("A");
        dsa.shortest_path.dijkstra.Node nodeB = new dsa.shortest_path.dijkstra.Node("B");
        dsa.shortest_path.dijkstra.Node nodeC = new dsa.shortest_path.dijkstra.Node("C");
        dsa.shortest_path.dijkstra.Node nodeD = new dsa.shortest_path.dijkstra.Node("D");
        dsa.shortest_path.dijkstra.Node nodeE = new dsa.shortest_path.dijkstra.Node("E");
        dsa.shortest_path.dijkstra.Node nodeF = new dsa.shortest_path.dijkstra.Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);

        System.out.println("\n\n");
//        List<Vertex> primsGraph =  Prim.createGraph();
//        Prim prim = new Prim(primsGraph);
//        prim.run();
//        prim.resetPrintHistory();
//        System.out.println(prim.minimumSpanningTreeToString());

    }
}