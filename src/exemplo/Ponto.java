package exemplo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Ponto implements Serializable{
	private int x, y;
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	
	public Ponto(){

	}

	public Ponto(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public long getID(){
		return id;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}
