class Node:
    def __init__(self,val:str):
        self.val = val
        self.children = dict()
        self.count = 0

class Trie:

    def __init__(self):
        self.root = Node("")

    def insert(self, word: str) -> None:
        temp = self.root
        for c in word:
            if c not in temp.children:
                temp.children[c] = Node(c)
            temp = temp.children[c]
        temp.count += 1

    def search(self, word: str) -> bool:
        temp = self.root
        for c in word:
            if temp and temp.children.get(c):
                temp = temp.children[c]
            else:
                return False
        return temp.count > 0


    def startsWith(self, prefix: str) -> bool:
        temp = self.root
        for c in prefix:
            if temp and temp.children.get(c):
                temp = temp.children[c]
            else:
                return False
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)