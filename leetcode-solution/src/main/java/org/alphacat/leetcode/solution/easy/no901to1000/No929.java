package org.alphacat.leetcode.solution.easy.no901to1000;

import java.util.HashSet;

public class No929 {

    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            String[] splitEmail = email.split("@");
            String localName = splitEmail[0];
            String domainName = splitEmail[1];
            localName = localName.replace(".", "");
            StringBuilder sb = new StringBuilder(localName);
            int plusIndex = sb.indexOf("+");
            if (plusIndex >= 0) {
                sb.delete(plusIndex, sb.length());
            }
            sb.append("@");
            sb.append(domainName);
            set.add(sb.toString());
        }
        return set.size();
    }
}
