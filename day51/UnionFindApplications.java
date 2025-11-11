package day51;

import java.util.*;

@SuppressWarnings("unused")
public class UnionFindApplications {
    public static void main(String[] args) {
        int n = 7;
        DisjointSet ds = new DisjointSet(n);

        // Example unions
        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 5);

        // Print parent structure
        ds.printParents();

        // Check if 3 and 7 belong to the same set
        if (ds.find(3) == ds.find(7 - 1)) {
            System.out.println("3 and 7 are in the same set");
        } else {
            System.out.println("3 and 7 are in different sets");
        }

        // Merge them and check again
        ds.union(3, 6);
        ds.printParents();

        if (ds.find(3) == ds.find(6)) {
            System.out.println("3 and 6 are now in the same set");
        }
    }
}
