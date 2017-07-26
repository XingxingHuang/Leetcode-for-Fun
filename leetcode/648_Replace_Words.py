#最最简单的做法，但是时间复杂度高一点
class Solution(object):
    def replaceWords(self, dict, sentence):
        dict = set(dict)
        res = []
        def add(word):
            for i in range(1, len(word)):
                if word[:i] in dict:
                    res.append(word[:i])
                    return
            res.append(word)
            
        words = sentence.split(" ")
        for word in words:
            add(word);
        return " ".join(res)
        
        


# 用trie tree
class Solution(object):
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        if sentence is None or sentence == "":
            return sentence
        words = sentence.split()
        ## build trie
        trie = Trie()
        for w in dict:
            trie.insert(w)
        ## search trie
        for i in range(len(words)):
            words[i] = self.replace(words[i], dict, trie)
        return " ".join(words)
    
    def replace(self, word, dicts, trie):
        minlen = 2000
        newlen = trie.search(word)
        if newlen != 0:
            return word[0:newlen]
        else:
            return word
            
        
class TrieNode:
    def __init__(self):
      self.childs = dict()
      self.isWord = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    # @param {string} word
    # @return {void}
    # Inserts a word into the trie.
    def insert(self, word):
        node = self.root
        for letter in word:
            child = node.childs.get(letter)
            if child is None:
                node.childs[letter] = TrieNode()
            node = node.childs[letter]
        node.isWord = True

    # @param {string} word
    # @return {boolean}
    # Returns if the word is in the trie.
    def search(self, word):
        node = self.root
        count = 0
        for letter in word:
            node = node.childs.get(letter)
            if node is None:
                return 0
            count += 1
            if (node.isWord):
                return count
        return 0
