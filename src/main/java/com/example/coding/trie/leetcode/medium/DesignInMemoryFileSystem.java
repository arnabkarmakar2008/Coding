package com.example.coding.trie.leetcode.medium;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=oXEPfYaMOwI
 *
 *
 */
public class DesignInMemoryFileSystem {

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "Arnab Karmakar");
        fileSystem.addContentToFile("/a/b/c/d", "Baishakhi Karmakar");
        System.out.println(fileSystem.readContentFromFile("/a/b/c/d"));
    }

}

class FileSystem {

    FileSysTrieNode root = new FileSysTrieNode();

    public FileSystem() {

    }

    /**
     * If path is file name then return the file name only
     * Else return list of file and dir under path
     * @param path
     * @return
     */
    public List<String> ls(String path) {
        FileSysTrieNode currentNode = root;

        if (!path.equals("/")) {
            String[] list = path.split("/");

            for (int ct = 0; ct < list.length; ct++) {
                if (root.children.containsKey(list[ct])) {
                    currentNode = root.children.get(list[ct]);

                    //Check if it is a file path, then return the file name only
                    if (currentNode.content != null && ct == path.length()-1) {
                        return Arrays.asList(list[ct]);
                    }
                }
            }
        }

        //If currentNode is root or any other node then return all children
        List<String> children = new ArrayList<>(currentNode.children.keySet());
        Collections.sort(children); //need to return in lexicographically order
        return children;
    }

    /**
     * Make a dir according to the given path. If the middle dirs do not exist then
     * we should create
     * @param path
     */
    public void mkdir(String path) {
        FileSysTrieNode currentNode = root;

        String[] pathArray = path.split("/");

        for (int ct = 0; ct < pathArray.length; ct++) {
            if (!currentNode.children.containsKey(pathArray[ct])) {
                currentNode.children.put(pathArray[ct], new FileSysTrieNode());
            }

            currentNode = currentNode.children.get(pathArray[ct]);
        }

    }

    /**
     * If filePath do not exist then create a new file with content
     * Else add the content in the file
     * @param filePath
     * @param content
     */
    public void addContentToFile(String filePath, String content) {
        FileSysTrieNode currentNode = root;

        String[] pathArray = filePath.split("/");

        for (int ct = 0; ct < pathArray.length; ct++) {
            if (!currentNode.children.containsKey(pathArray[ct])) {
                currentNode.children.put(pathArray[ct], new FileSysTrieNode());
            }

            currentNode = currentNode.children.get(pathArray[ct]);
        }

        if (currentNode.content == null) {
            currentNode.content = content;
        } else {
            StringBuffer sb = new StringBuffer(currentNode.content);
            sb.append(content);
            currentNode.content = sb.toString();
        }

    }

    /**
     * Returns content of the file
     * @param filePath
     * @return
     */
    public String readContentFromFile(String filePath) {
        FileSysTrieNode currentNode = root;

        String[] pathArray = filePath.split("/");

        for (int ct = 0; ct < pathArray.length; ct++) {
            currentNode = currentNode.children.get(pathArray[ct]);
        }

        return currentNode.content;

    }

}

class FileSysTrieNode {
    String content;
    Map<String, FileSysTrieNode> children = new HashMap<>();
}
