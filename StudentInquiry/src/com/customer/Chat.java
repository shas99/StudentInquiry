package com.customer;

public class Chat {//Class chat

	private int chatID;
	private String chat;
	private String username;
	private String studentID;
	public Chat(int chatID, String chat, String username, String studentID) {
		this.chatID = chatID;
		this.chat = chat;
		this.username = username;
		this.studentID = studentID;
	}
	public int getChatID() {
		return chatID;
	}
	
	public String getChat() {
		return chat;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getStudentID() {
		return studentID;
	}
	
	
	
	
}
