package com.lifelibrarians.lifebookshelf.interview.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Getter
@Schema(description = "인터뷰 질문 응답 정보")
@ToString
public class InterviewQuestionDto {

	@Schema(description = "질문 ID", example = "1")
	private final Long questionId;

	@Schema(description = "질문 순서", example = "1")
	private final int order;

	@Schema(description = "질문 내용", example = "What is your name?")
	private final String questionText;
}
