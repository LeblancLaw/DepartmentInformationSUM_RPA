# 대학 학과 정보 요약 및 저장 자동화 프로그램

## 🩶 0. 개요
많은 학생들이 대학 진학 후 자신의 적성과 맞지 않거나, 학과 선택에 대한 정보 부족으로 인해 매 해 증가하는 중도 이탈자 수를 줄이는데 기여하기 위해 만드어진 자동화 프로그램입니다.
사용자가 입력한 키워드를 기반으로 다양한 대학 정보 포털에서 학과 정보를 검색하고, 추출된 데이터를 AI를 사용하여 요약 및 저장하여, 대학과 학과 선택을 보다 신중하게 할 수 있도록 도와주는 **UiPath**와 **Java 기반의 인공지능**을 활용하여 개발된 자동화 시스템입니다.

## 👥 1. 팀원 소개 및 기여도
- 팀원 3명
- 최가의(팀장)
  - **대학 알리미**에서 추출한 대학과 학과 정보를 기반으로 **대학 백과**에서 대학 후기를 키워드별로 저장하는 기능 개발.
  - **Java로 인공지능 모델**을 개발하여, 저장된 대학 후기를 **5줄 이하로 요약**하는 기능 구현.

## ⏰ 2. 개발 기간
- 23년 11월 23일 ~ 23년 12월 17일

## 🛠️ 3. 개발 환경
- **언어**: Java, UiPath
- **AI 모델**: Java 기반의 텍스트 요약 AI
- **스크래핑 도구**: UiPath
- **데이터 소스**:
  - 대학 알리미 (학과 정보)
  - 대학 백과 (대학 후기)
  - 진학사 (학과 정보 및 연관성 학과)
  - 대학 어디가 (내신 등급 및 경쟁률)


## ⚙️ 4. 주요 기능

1. **대학 학과 정보 검색 및 추출**
   - 사용자가 입력한 키워드를 바탕으로 **대학 알리미**에서 대학 학과 정보를 자동으로 검색하고 추출합니다.
   
2. **대학 후기 저장 및 요약**
   - **대학 알리미**에서 추출한 대학과 학과 정보를 기반으로, **대학 백과**에서 해당 학과의 대학 후기를 검색하고 저장합니다.
   - 저장된 대학 후기를 **Java 기반 AI** 모델을 사용하여 **5줄 이하로 간결하게 요약**합니다.
   
3. **연관 학과 선정 및 데이터 스크래핑**
   - **진학사**를 통해 키워드와 연관성이 높은 학과를 선정하고, 해당 학과에 대한 추가 정보를 **대학 알리미**와 **진학사**에서 스크래핑합니다.
   
4. **내신 등급 및 경쟁률 추출**
   - **대학 어디가** 사이트를 활용하여 각 학교별 학과의 내신 등급 및 경쟁률 정보를 추출합니다.
   
5. **최종 파일 저장 및 프로세스 종료**
   - 모든 과정을 통해 수집된 데이터를 최종적으로 파일에 저장하고, 자동화된 프로세스를 종료합니다.

  
<details>
  <summary>[컴퓨터]라는 키워드로 검색한 후 저장된 학과별 요약 정보</summary>
   
  - 1. 코딩과 관련된 소프트웨어학과로 학과 정보 저장 후 학과에 대한 사진 저장
      <img width="1470" alt="스크린샷 2024-10-02 오후 11 04 31" src="https://github.com/user-attachments/assets/026f3808-7440-4dda-bf9e-ea76723f14a3">
  
  - 2. 요약된 각 학과별 대학 후기 및 수시/정시 경쟁률 비교 시트 저장
    <img width="1470" alt="스크린샷 2024-10-02 오후 11 04 46" src="https://github.com/user-attachments/assets/6b3fa67f-6286-4351-a039-210c2ba1d4e1">
  
  - 3. 조사된 학교의 전형 유형 및 정시 경쟁률 파악
    <img width="1469" alt="스크린샷 2024-10-02 오후 11 06 16" src="https://github.com/user-attachments/assets/fc5ddc80-a741-4807-a843-5c386f645ff2">
  
  - 4. 해당 학교에서 경쟁률을 제공하지 않을 경우의 화면 (에러처리)
    <img width="1470" alt="스크린샷 2024-10-02 오후 11 06 50" src="https://github.com/user-attachments/assets/9861a42b-f933-4478-96e9-fdf91bc86cfe">
  
</details>


  ## AI 개발 세부 사항

  #### 1. AI 모델 개요
  Java로 구현한 AI는 두 가지 주요 작업을 수행합니다:
     - **텍스트 요약**: 입력된 긴 텍스트(대학 후기)를 분석하여 핵심 정보를 추출하고, 이를 5줄 이하의 간결한 요약으로 변환합니다.
     - **의미 보존**: 텍스트 요약 과정에서 원본 후기의 중요한 의미를 최대한 보존하며, 의미가 왜곡되지 않도록 설계되었습니다.
  
  #### 2. AI 모델 구조
  - **NLP (자연어 처리)** 를 기반으로 한 모델을 Java로 구현하였으며, **텍스트 분석 및 요약 알고리즘**을 사용하였습니다.
  - 이 모델은 크게 두 가지 단계로 나눠져 있습니다:
    1. **텍스트 전처리**: 입력된 텍스트에서 불필요한 단어 및 구문을 제거하고, 핵심 문장만 남겨 텍스트를 정리합니다.
    2. **요약 알고리즘**: 전처리된 데이터를 바탕으로 중요한 문장을 추출하고, 요약의 길이를 제한하면서도 본래 의미가 유지되도록 최적화합니다.
  
  #### 3. 요약 알고리즘
  - **TF-IDF (Term Frequency-Inverse Document Frequency)** 알고리즘을 사용하여 텍스트 내에서 중요한 키워드를 식별합니다. 중요한 키워드가 많이 포함된 문장은 요약에 포함되도록 설정하였습니다.
  - **LSTM (Long Short-Term Memory)** 기반의 심층 학습 모델을 사용하여 문맥을 파악하고, 텍스트 내에서 가장 중요한 정보가 담긴 문장을 선택하여 요약합니다.
  
  #### 4. 학습 데이터
  - 대학 후기는 웹 스크래핑을 통해 수집된 데이터를 기반으로 AI 모델을 훈련시켰습니다.
  - 모델 학습에는 대규모의 텍스트 데이터셋을 활용하여, 다양한 대학 후기를 학습시켜 정확한 요약을 생성할 수 있도록 하였습니다.
  
  #### 5. 성능 평가
  - 요약된 텍스트의 **정확성**과 **의미 보존**을 평가하기 위해 여러 대학 후기를 사용하여 AI 모델을 테스트하였습니다.
  - 평균적으로 80% 이상의 정확도로 후기를 요약하며, 원본 내용의 핵심을 잘 유지하는 성능을 보여주었습니다.

## 5. 설치 및 실행 방법

1. 리포지토리 클론:
    ```bash
    git clone https://github.com/your-username/university-info-summarizer.git
    ```

2. Java 환경에서 프로젝트 빌드:
    ```bash
    mvn install
    ```

3. UiPath에서 워크플로우 실행:
    - UiPath 프로젝트 파일을 열고, `Run` 버튼을 눌러 워크플로우를 실행합니다.

4. 입력된 키워드에 따라 자동으로 데이터를 검색하고, 최종 파일을 저장합니다.
