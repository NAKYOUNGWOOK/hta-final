<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="tmp" items="${list}">
	<div class="chat_list_box${tmp.room} chat_list_box">
		<div type="button" class="chat_list" room="${tmp.room}" other="${tmp.other}">
			
			<!-- active-chat -->
			<div class="chat_people">
				<div class="chat_img">
					<a href="other_profile.do?other=${tmp.other}">
						<img src="./upload/profile/${tmp.profile}" alt="sunil">
					</a>
				</div>
				<div class="chat_ib">
					<h5>${tmp.other}<span class="chat_date">${tmp.sendtime}</span>
					</h5>
					<div class="row">
						<div class="col-10">
							<p>${tmp.content}</p>
						</div>
						
						<%-- 현재 사용자가 안 읽은 메세지 갯수가 0보다 클 때는 badge를 표시 --%>
						<c:if test="${tmp.unread > 0}">
							<div class="col-2 unread${tmp.room}">
								<span class="badge bg-danger">${tmp.unread}</span>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:forEach>
	