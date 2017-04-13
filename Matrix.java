package matrix;

public class Matrix {
	public Node _head = new Node(0);
	public float _default;
	public int _m;
	public int _n;
	
	public Matrix(float def, int m, int n){
		_m = m;
		_n = n;
		_default = def;
	}
	
	public Matrix(int m, int n){
		_m = m;
		_n = n;
		_default = 0;
	}
	
	public boolean does_intersect(Node i, Node j){
		while(i.get_down() != null){
			Node r = j;
			while (r.get_down() != null){
				if(r == i){
					return true;
				}
				r = r.get_right();
			}
			i = i.get_down();
		}
		return false;
	}
	
	public float get_intersection(Node col, Node row){
		while(col != null){
			Node r = row;
			while(r != null){
				if(r == col){
					return r.get_contents();
				}
				r = r.get_right();
			}
			col = col.get_down();
		}
		return _default;
	}
	
	public float get_val(int i, int j){
		if(i == 0 || j == 0){
			//throw index error
			return -1;
		}
		if(i > _m || j > _n){
			//throw index error
			return -1;
		}
		// If matrix is only default.
		if(_head.get_right() == null && _head.get_down() == null){
			return _default;
		}
		Node x_node = _head;
		Node y_node = _head;
		while(x_node.get_contents() != i){
			if(x_node.get_right() == null){
				return _default;
			}
			x_node = x_node.get_right();
		}
		while(y_node.get_contents() != j){
			if(y_node.get_down() == null){
				return _default;
			}
			y_node = y_node.get_down();
		}
		return get_intersection(x_node, y_node);	
	}
	
	public void set_val(float i, float j, float val){
		Node new_node = new Node(val);
		if(_head.get_right() == null || _head.get_down() == null){
			Node new_right = new Node(i);
			_head._right = new_right;
			Node new_down = new Node(j);
			_head._down = new_down;
			new_right.set_down(new_node);
			new_down.set_right(new_node);
			
		}
		else{
			// Go to indexed column
			Node right = _head;
			Node down = _head;
			while(right.get_contents() < i){right = right.get_right();}
			int intersect_count = 0;
			while(down != null){
				if(does_intersect(right, down) && down.get_contents() < j){
					intersect_count ++;
				}
				down = down.get_down();
			}
			int x = 1;
			while(x < intersect_count){
				right = right.get_down();
				x ++;
			}
			new_node.set_down(right.get_down());
			right.set_down(new_node);		
			
			// Go to indexed row
			down = _head;
			right = _head;
			while(down.get_contents() < j){down = down.get_down();}
			intersect_count = 0;
			while(right != null){
				if(does_intersect(right, down) && down.get_contents() < i){
					intersect_count ++;
				}
				right = right.get_right();
			}
			x = 1;
			while(x < intersect_count){
				down = down.get_right();
				x ++;
			}
			new_node.set_right(down.get_right());
			down.set_right(new_node);
		}
		return;
	}
	
	public Matrix get_row(int row){
		Matrix output_matrix = new Matrix(_m, 1);
		int x = 0;
		while(x < _m){
			output_matrix.set_val(1, x, get_val(row, x));
		}
		return output_matrix;
	}
	
	public void set_row(Node row, float val){
		while(row.get_right() != null){
			row = row.get_right();
			row.set_contents(val);
		}
	}
	
	public String print_matrix(){
		int x = 1;
		int y = 1;
		String output = "";
		while(y != _n){
			x = 1;
			while(x != _m){
				output += get_val(x, y);
				output += " ";
				x ++;
			}
			output += "\n";
			y ++;
		}
		return output;
	}
	
	public String print_node_pointers(){
		String output = "";
		Node y = _head;
		Node x;
		while(y != null){
			x = y;
			while(x != null){
				output += x.get_contents();
				output += " ";
				x = x.get_right();
			}
			output += "\n";
			y = y.get_down();
		}
		return output;
	}
}
