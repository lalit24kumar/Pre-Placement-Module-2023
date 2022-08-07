class Solution {
    public int findCircleNum(int[][] M) {
        int parent[]=new int[M.length];
        for(int i=0;i<parent.length;i++) {
        	parent[i]=i;
        }
        for(int i=0;i<M.length;i++) {
        	for(int j=0;j<M[0].length;j++) {
        		if(M[i][j]==1) {
        			union(parent, i, j);
        		}
        	}
        }
        int count=0;
        for(int i=0;i<parent.length;i++) {
        	if(parent[i]==i) {
        		count++;
        	}
        }
        return count;
    }
    public int find(int[] indexs,int index) {
    	while(indexs[index]!=index) {
    		index=indexs[index];
    	}
    	return index;
    }
    public void union(int[] indexs,int i,int j) {
    	int parenti=find(indexs, i);
    	int parentj=find(indexs, j);
    	if(parenti<parentj) {
    		indexs[parentj]=parenti;
    	}else {
    		indexs[parenti]=parentj;
    	}
    }
}