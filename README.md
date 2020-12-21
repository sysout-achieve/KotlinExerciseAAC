# KotlinExerciseAAC
AAC 연습프로젝트(Kotlin)


1. Room(비동기 처리를 위한 coroutine)
2. LiveData
3. ui와 로직분리를 위한 ViewModel
4. DataBinding


## Coroutine
- 비동기 처리를 위해 만들어진 협력형 멀티태스킹 장치

<img src="https://user-images.githubusercontent.com/18481078/63651705-a0e49b80-c792-11e9-9924-eb737b813065.png" width="50%" height="50%"/>
<br>

[이미지 출처](https://wooooooak.github.io/kotlin/2019/08/25/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%BD%94%EB%A3%A8%ED%8B%B4-%EA%B0%9C%EB%85%90-%EC%9D%B5%ED%9E%88%EA%B8%B0/) 

- suspend 함수와 코루틴을 사용하면 비동기 코드를 동기코드처럼 짤 수 있다. (kotlin 기준)
: suspend키워드의 메서드를 호출하는동안(지연되는 시간동안) 자원을 반환하고 메서드가 완료된 후 기존의 자원을 이용하여 코루틴 스코프안의 다음 라인을 진행한다.
  코루틴을 위 방식을 이용해 자원을 효율적으로 관리하고 비동기처리를 할 수 있다.

<hr>

## Room

SQLite에 대한 추상화 레이어를 제공 데이터베이스 액세스 지원 및 SQLite 활용<br>
<br>
![https://developer.android.com/training/data-storage/room](https://developer.android.com/images/training/data-storage/room_architecture.png) 
<br>
*룸 아키텍쳐 다이어그램*
<br><br>
- 앱이 단일프로세스에서 실행될 경우 AppDatabase 객체를 인스턴스화할 때 싱글톤 디자인 패턴을 따라야 함.(각 RoomDatabase 인스턴스는 리소스를 많이 소비함)<br>
앱이 여러 프로세스에서 실행되면 데이터베이스 빌더 호출 시 enableMultiInstanceInvalidation)을 포함해야함. <br>
각 프로세스에 AppDatabase 인스턴스가 있을 때 한 프로세스에서 공유 데이터베이스 파일을 무효화 --> 이 무효화는 다른 프로세스 내 AppDatabase 인스턴스로 자동 전달됨
<br>
<br>
<br>

## LiveData

이점 :
1. UI와 데이터 상태의 일치 보장 - LiveData는 Observer패턴을 사용. 앱 데이터가 변경될 때마다 UI를 업데이트 할 수 있음.<br>
2. 메모리 누출 없음 - Lifecycle 객체에 결합되어 있으며 연결된 수명주기가 끝나면 자동으로 삭제됨.<br>
3. 중지된 활동으로 인한 비정상 종료 없음<br>
4. 수명주기를 수동으로 처리하지 않음<br>
5. 최신 데이터 유지<br>
6. 구성변경으로 인해(기기 회전 등) 화면이 다시 생성되어도 최신정보를 즉시 수신함
