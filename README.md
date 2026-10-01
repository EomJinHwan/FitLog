# FitLog

> 운동 기록을 날짜별로 관리하는 Spring Boot 기반 백엔드 API

## 프로젝트 소개

FitLog는 사용자의 운동 기록을 관리하기 위한 백엔드 API 프로젝트입니다.

회원가입/로그인과 JWT 인증을 기반으로
사용자별 운동 종목 및 운동 기록을 관리할 수 있도록 구현했습니다.

운동 기록은 상세 조회, 삭제, 날짜별 조회, 월별 조회를 지원하며
다른 사용자의 기록에 접근할 수 없도록 소유자 검증을 적용했습니다.

현재 v1 기능 구현을 완료했으며,
이후 통계, 테스트, 배포, AI 기반 운동 추천 기능으로 확장할 예정입니다.

## 개발 목적

기존 학습용 쇼핑몰 API 프로젝트에서 경험한 CRUD, MySQL, Spring Security, JWT 인증 흐름을 바탕으로, 직접 주제를 정하고 설계한 개인 프로젝트를 구현하는 것이 목표입니다.

이번 프로젝트를 통해 다음 내용을 연습합니다.

* Spring Boot 기반 REST API 설계
* MySQL과 JPA 연동
* Entity, Repository, Service, Controller 계층 분리
* DTO를 이용한 요청/응답 분리
* BCrypt를 이용한 비밀번호 암호화
* JWT Access Token 발급
* Spring Security 기반 인증 흐름
* 사용자별 운동 기록 관리
* JPA 연관관계 설계
* 날짜 기반 운동 기록 조회

## 기술 스택

### Backend

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* MySQL
* Gradle

### Authentication

* BCrypt PasswordEncoder
* JWT Access Token

### Documentation

* Notion
* README.md

## 향후 계획

* 운동 통계 기능
* 테스트 및 예외 처리 보강
* Docker 및 배포 환경 구성
* LLM API를 활용한 운동 추천 기능
