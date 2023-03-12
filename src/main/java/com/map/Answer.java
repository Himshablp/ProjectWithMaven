package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@Column(name="answer_Id")
	private int answerId;
	private String answer;
	
	@ManyToOne
	private Question ques;
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question getQues() {
		return ques;
	}
	public void setQues(Question ques) {
		this.ques = ques;
	}
	

}
