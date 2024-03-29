# project_newPostLink 개요
티스토리 블로그 포스팅 중 목차에 링크를 추가하는 웹 프로젝트
(서드파티 특성상 현재 티스토리 마크다운 패치로 인해 본인 이외 사용하기 힘들어짐)

blog post : https://fadet-coding.tistory.com/55

- 문제 발생 : 블로그에 포스팅할때 글의 말머리에 목차를 넣고 이에 링크를 달기 위해선 직접 마크다운을 일일이 수정해줘야 하기에 불편함
- 해결 : html을 복사해 웹 서비스에서 가공하면 자동으로 목차와 링크가 추가된 html이 생성


![image](https://user-images.githubusercontent.com/96664524/191516014-9cdf3c0c-fcde-46f2-9100-098099f93fec.png)

# 사용 기술

- Spring Boot : junit을 사용한 테스트 코드 활용으로 TDD 학습, 트랜잭션 스크립트 대신 도메인 모델 패턴을 지향

# ver 1.0.0
- html 수정 기본 기능 구현

# ver 1.0.1
- 성능을 위해 for문 사용 코드 내부 string builder로 교체(단일 thread므로 buffer x)
- 변환 함수 init에 설명 추가
- iteratordml for문을 stream으로 교체, builder의 경우 가독성을 위해 for문 유지(메서드 참조는 자바 사용자가 아니면 알지 못하므로 사용하지 않음)
- 테스트 데이터 수정
- 240108 확인 결과 티스토리 레이아웃 로직 변경으로 사용시 일일이 html을 찝어줘야해서 타인이 사용하기 어려움
