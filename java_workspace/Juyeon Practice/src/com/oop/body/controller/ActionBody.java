package com.oop.body.controller;

import com.oop.body.model.Arm;
import com.oop.body.model.Body;
import com.oop.body.model.Head;
import com.oop.body.model.Leg;

public class ActionBody {

	public static void main(String[] args) {
		ActionBody ab = new ActionBody();
		ab.test1();
	

	}
	
	public void test1() {
		
		Body[] arr = new Body[5];
		arr[0] = new Head();
		arr[1] = new Arm();
		arr[2] = new Leg();
		arr[3] = new Head();
		arr[4] = new Leg();
		
		for(Body bdy : arr) {
			bdy.doing();
			
			if(bdy instanceof Head) {
				((Head)bdy).headBang();
			}
			else if(bdy instanceof Arm) {
				((Arm)bdy).armSwing();
			}
			else {
				((Leg)bdy).run();
				
			}
		}
	}




	}


