package com.lifelibrarians.lifebookshelf.notification.domain;

import com.lifelibrarians.lifebookshelf.member.domain.Member;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "notificationSubscribes")
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NotificationSubscribe {

	/* 고유 정보 { */
	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime subscribedAt;
	/* } 고유 정보 */

	/* 연관 정보 { */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "notification_id", nullable = false)
	private Notification notification;
	/* } 연관 정보 */

	/* 생성자 { */
	protected NotificationSubscribe(LocalDateTime subscribedAt) {
		this.subscribedAt = subscribedAt;
	}

	public static NotificationSubscribe of(LocalDateTime subscribedAt) {
		return new NotificationSubscribe(subscribedAt);
	}
	/* } 생성자 */
}
