# FitLog

> 운동 기록을 날짜별로 관리하고, 최근 수행 기록과 컨디션을 기반으로 다음 운동 목표를 추천하는 Spring Boot 기반 백엔드 API

## 프로젝트 소개

FitLog는 사용자의 운동 기록을 관리하기 위한 백엔드 API 프로젝트입니다.

단순히 운동 기록을 저장하는 CRUD API를 넘어, 추후에는 사용자의 최근 운동 기록을 기반으로 다음 운동 목표를 추천하고, 월별 운동 기록 조회, 운동 통계 조회 기능까지 확장하는 것을 목표로 합니다.

현재 1차 구현 단계에서는 프로젝트 기본 구조를 잡고, 회원가입/로그인, JWT 인증, 운동 종목 등록/조회/삭제 기능을 구현했습니다.

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
* 기록 기반 추천 로직 구현

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
