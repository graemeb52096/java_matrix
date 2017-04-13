package matrix;

public class Node {
	// Matrix node
	public float _contents = 0;
	public Node _right = null;
	public Node _down = null;
	
	public Node(float contents){
		_contents = contents;
	}
	
	public Node(float contents, String place, Node node){
		_contents = contents;
		if(place == "down"){
			_down = node;
		}
		else{
			_right = node;
		}
	}
	
	public Node(float contents, Node right, Node down){
		_contents = contents;
		_right = right;
		_down = down;
	}
	
	public float get_contents(){
		return _contents;
	}
	
	public Node get_right(){
		return _right;
	}
	
	public Node get_down(){
		return _down;
	}
	
	public void set_contents(float value){
		_contents = value;
		return;
	}
	
	public void set_right(Node right){
		_right = right;
	}
	
	public void set_down(Node down){
		_down = down;
	}	
}
