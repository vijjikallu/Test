package com.project.service;

import com.project.model.EmailMessage;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	// For a non-bloockin experience, we can use disruptor ring-buffer
	private BlockingQueue<EmailMessage> emailMessageQueue = new ArrayBlockingQueue<EmailMessage>(1000);
	private ExecutorService executorService = Executors.newFixedThreadPool(1);

	public void EmailServiceImpl() {
		executorService.submit(() -> {
			while (true) {
				EmailMessage emailMessage = emailMessageQueue.poll();
				// Send email invitation message
			}
		});
	}

	public void send(EmailMessage emailMessage) {
		emailMessageQueue.add(emailMessage);
	}

}
