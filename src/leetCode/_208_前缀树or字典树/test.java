package leetCode._208_前缀树or字典树;

public class test {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app"));// 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 false


    }
}
