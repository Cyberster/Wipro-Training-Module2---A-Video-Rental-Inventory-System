package com.w3epic.wiprotraining;

import java.util.Scanner;

class Video {
	private String videoName;
	private boolean checkout;
	private int rating;
	
	public Video(String name) {
		videoName = name;
	}
	
	public String getName() {
		return videoName;
	}
	
	public void doCheckout() {
		checkout = true;
	} 
	
	public void doReturn() {
		checkout = false;
	}
	
	public void receiveRating(int rating) {
		this.rating = rating;
	}
	
	public int getRating() {
		return rating;
	}
	
	public boolean getCheckout() {
		return checkout;
	}
}

class VideoStore {
	private Video[] store;
	
	void addVideo(String name) {
		Video video = new Video(name);
		int storeSize;
		
		try {
			storeSize = store.length;
		} catch (Exception e) {
			storeSize = 0;
		}
		
		Video[] newStore = new Video[storeSize + 1];
		newStore[storeSize] = video;
		store = newStore;
	}

	void doCheckout(String name) {
		for (Video video : store) {
			if (video.getName().equals(name)) {
				video.doCheckout();
			}
		}
	}
	
	void doReturn(String name) {
		for (Video video : store) {
			if (video.getName().equals(name)) {
				video.doReturn();
			}
		}
	}
	
	void receiveRating(String name, int rating) {
		for (Video video : store) {
			if (video.getName().equals(name)) {
				video.receiveRating(rating);
			}
		}
	}
	
	void listInventory() {
		for (int i = 0; i < 80; i++) System.out.print("-");
		System.out.printf("\n\t%-20s\t|\t%-10s\t|\t%-15s\n", "Name", "Rating", "Checkout");
		for (int i = 0; i < 80; i++) System.out.print("-");
		
		for (Video video : store) {
			System.out.printf("\n\t%-20s\t|\t%-10s\t|\t%-15s\n", video.getName(), video.getRating(), video.getCheckout());
		}
		
		for (int i = 0; i < 80; i++) System.out.print("-");
	}
}

public class VideoLauncher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VideoStore store = new VideoStore();
		int choice = 0;
		
		do {
			System.out.println("\n1. Add Videos: \n" + 
								"2. Check Out Video: \n" + 
								"3. Return Video: \n" + 
								"4. Receive Rating: \n" + 
								"5. List Inventory: \n" + 
								"6. Exit: \n" + 
								"Enter your choice (1..6): ");
			choice = sc.hasNextInt() ? sc.nextInt() : 6;
			sc.nextLine();
			
			String name;
			
			switch (choice) {			
			case 1:
				System.out.println("Enter the name of the video you want to Add: ");
				name = sc.nextLine();
				store.addVideo(name);
				System.out.println("Video " + name + " added out successfully.");
				break;
			case 2:
				System.out.println("Enter the name of the video you want to Checkout: ");
				name = sc.nextLine();
				store.doCheckout(name);
				System.out.println("Video " + name + " checked out successfully.");
				break;
			case 3:
				System.out.println("Enter the name of the video you want to Return: ");
				name = sc.nextLine();
				store.doReturn(name);
				System.out.println("Video " + name + " returned successfully.");
				break;
			case 4:
				System.out.println("Enter the name of the video you want to Rate: ");
				name = sc.nextLine();
				System.out.println("Enter the rating for this video: ");
				int rating = sc.nextInt();
				store.receiveRating(name, rating);
				System.out.println("Rating " + rating + " has been mapped to the Video " + name + ".");
				break;
			case 5:
				store.listInventory();
				break;
			default:
				System.out.println("Exiting...!! Thanks for using the application.");
				break;
			}
		} while (choice != 6);

		sc.close();
	}

}
