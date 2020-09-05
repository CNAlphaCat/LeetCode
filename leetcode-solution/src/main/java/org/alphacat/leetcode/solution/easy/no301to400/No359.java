package org.alphacat.leetcode.solution.easy.no301to400;

import java.util.HashMap;

public class No359 {
	class Logger {
		HashMap<String, Integer> map;

		/** Initialize your data structure here. */
		public Logger() {
			map = new HashMap<String, Integer>();
		}

		/**
		 * Returns true if the message should be printed in the given timestamp,
		 * otherwise returns false. If this method returns false, the message will not
		 * be printed. The timestamp is in seconds granularity.
		 */
		public boolean shouldPrintMessage(int timestamp, String message) {
			if (!map.containsKey(message)) {
				map.put(message, timestamp);
				return true;
			}
			int timeDiff = timestamp - map.get(message);
			if (timeDiff >= 10) {
				map.put(message, timestamp);
				return true;
			}
			return false;
		}
	}
}
