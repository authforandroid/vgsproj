package com.vgs.beans;

public class Member {

	Person Self;
	Person Parent;
	Relationship Relation;
	public Member() {

	}
	public Person getSelf() {
		return Self;
	}
	public void setSelf(Person self) {
		Self = self;
	}
	public Person getParent() {
		return Parent;
	}
	public void setParent(Person parent) {
		Parent = parent;
	}
	public Relationship getRelation() {
		return Relation;
	}
	public void setRelation(Relationship relation) {
		Relation = relation;
	}
}
