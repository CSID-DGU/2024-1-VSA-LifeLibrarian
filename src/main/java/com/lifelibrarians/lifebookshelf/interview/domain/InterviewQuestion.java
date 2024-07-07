package com.lifelibrarians.lifebookshelf.interview.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "interviewQuestions")
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InterviewQuestion {

	/* 고유 정보 { */
	@Id
	@Column(nullable = false, updatable = false)
	private String id;

	@Column(nullable = false, name = "\"order\"")
	private Integer order;

	@Column(nullable = false)
	private String questionText;

	@Column(nullable = false)
	private LocalDateTime createdAt;
	/* } 고유 정보 */

	/* 연관 정보 { */
	@OneToMany(mappedBy = "currentQuestion")
	private Set<Interview> currentQuestionInterviews;
	/* } 연관 정보 */

	/* 생성자 { */
	protected InterviewQuestion(String id, Integer order, String questionText,
			LocalDateTime createdAt) {
		this.id = id;
		this.order = order;
		this.questionText = questionText;
		this.createdAt = createdAt;
	}

	public static InterviewQuestion of(String id, Integer order, String questionText,
			LocalDateTime createdAt) {
		return new InterviewQuestion(id, order, questionText, createdAt);
	}
	/* } 생성자 */
}
