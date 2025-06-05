
# A Trie (pronounced as "try") is a tree-like data structure that stores a dynamic set of strings. 
# Tries are commonly used to facilitate operations like prefix matching and string lookups.


# Implementation of Trie data structure

class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False

    def __repr__(self):
        return f"TrieNode({self.children.keys()}, {self.is_end_of_word})"

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end_of_word = Trueb bbbbjb                                                                                                                                                      
        

    def search(self, word):

        
    
    // write a phython code to print first 10 prime numbers

    def 


# Theoretical analysis 



# Empirical analysis