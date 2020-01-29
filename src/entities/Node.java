package entities;
public class Node {
    private int x;
    private int y;
    private int originDistance;
    Node parent = null;
    
    public Node(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.originDistance = dis;
    }
    
    public Node(int x, int y, int dis, Node parent) {
    	this.x = x;
        this.y = y;
        this.originDistance = dis;
        this.parent = parent;
    }
    
    public int getOriginDistance() {
    	return this.originDistance;
    }
    
    public int getX() {
    	return this.x;
    }
    
    public int getY() {
    	return this.y;
    }
    public Node myParents() {
    	if(this.parent == null) {
    		return null;
    	} else {
    		System.out.println(parent);
    		return this.parent.myParents();
    	}
    	
    }

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + ", originDistance=" + originDistance + "]";
	}
    
    
}