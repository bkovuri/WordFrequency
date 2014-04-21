WordFrequency
=============


      I have explored following data structures to calculate word frequency. 
      
      1) PriorityQueue: With priority queue we can find element with max frequency in O(1) time. 
         But the disadvantage with priority queue is for every search we need to remove K elements from queue and re-insert them.
      2) Complete Balanced Binary Search Tree: O(log n) for insertion, search, deletion. 
         But to search for K elements using inorder we need to traverse whole tree. In efficient in terms of space and time
      3) TreeMap: Explored if I could use TreeMap with sorted order on frequency. But as we can have multiple nodes
         with same frequency. frequency cannot be key in the tree.
      4) HashMap(Implemented): Built hashmap from input string, and created sorted array. This approch takes O (n log n)
         to build sorted array. And after that search operations are O(K). In this implementation we parse string 
         once, and handle search on parsed string. 
         
         
         
