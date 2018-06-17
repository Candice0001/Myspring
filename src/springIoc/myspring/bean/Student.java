package springIoc.myspring.bean;

/**
 * 
 * Title: Student.java
 * Description: 
 * @author chengge
 * @date 2018年5月23日
 *
 */
public class Student {
	
	private String stuno;
	private float score;
	private String classname;
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Override
	public String toString() {
		return "Student [stuno=" + stuno + ", score=" + score + ", classname=" + classname + "]";
	}
	

}
