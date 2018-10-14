package com.sample.stack;
/*
给定一个文档 (Unix-style) 的完全路径，请进行路径简化。

例如，
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

边界情况:

你是否考虑了 路径 = "/../" 的情况？
在这种情况下，你需返回 "/" 。
此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 * */
public class SimplifyPath {
	public static void main(String args[]) {
		String s = new SimplifyPath().simplifyPath("/home/../../..");
		byte[] bs = s.getBytes();
		for(int i = 0;i<bs.length;i++) {
	     	System.out.println(bs[i]);
		}
		System.out.println(s);
	}
	
    public String simplifyPath(String path) {
    	    path+="/";
        char[] queue = new char[path.length() + 1];
        int pos = 0;
        for(int i = 0;i < path.length(); i++) {
        	    char c = path.charAt(i);
        	    if(pos == 0) {
        	    	    queue[0] = c;
        	    	    pos++;
        	    	    continue;
        	    }
        	    if(c == '.') {
        	    	    queue[pos] = c;
        	    	    pos++;
        	    }else if(c == '/') {
        	    	    if(queue[pos - 1] == '.') {
        	    	    	    if(pos > 2 && queue[pos - 2] == '.') {
						if (!(pos > 3 && queue[pos - 3] == '.')) {
							int loop = 0;
							while (pos > 1 && loop < 2) {
								if (queue[pos - 1] == '/') {
									loop++;
								}
								if(loop < 2) {
								    pos--;
								}
							}
						}else {
							queue[pos] = c;
							pos++;
						}
        	    	    	    }else {
        	    	    	    	    if(pos > 2) {
        	    	    	    	        pos -= 1;
        	    	    	    	    }else {
        	    	    	    	    	    pos = 1;
        	    	    	    	    }
        	    	    	    }
        	    	    }else if(queue[pos-1] == '/') {
        	    	    	    continue;
        	    	    }else {
        	    	    	    queue[pos] = c;
        	    	    	    pos++;
        	    	    }
        	    }else {
        	    	    queue[pos] = c;
        	    	    pos++;
        	    }
        }
        
        if(pos > 1 && queue[pos - 1] == '/') {
        	    pos--;
        }
        
		if(pos == 0) {
			return "/";
		}
        return new String(queue, 0, pos);
    }
}