// 초기화
const mainSidebarWrapper = document.getElementById("wrap-sidebar-main");
const mainSidebarBody = document.getElementById("body-sidebar-main");
const subSidebarWrapper = document.getElementById("wrap-sidebar-sub");

// 현재 열린 항목의 id (메인 사이드바)
let openedElementId = null;

// 사이드바 열고 닫기
//클릭가능한 메인 사이드바 요소들 가져오기
const adjTestElements = document.getElementsByClassName("ele-sidebar-main");
//배열화후 forEach(각각 실행해줄 함수) 로 각 요소들에게 클릭이벤트 할당
Array.from(adjTestElements).forEach(function(element) {
    //클릭이벤트 할당
    element.addEventListener("click", function(event) {
        //테스트
        console.log("openedElementId = " + openedElementId);
        console.log("event.target.id = " + event.target.id);

        //현재 열렸는지 체크
        if(openedElementId === null) {
            //닫혀있음 - 열어준다(메인/서브 둘다 개봉)
            //열린항목 id 저장
            openedElementId = event.target.id;
            //메인사이드바 조절
            mainSidebarWrapper.classList.remove("adj-sidebar-main--open");
            mainSidebarWrapper.classList.add("adj-sidebar-main--close");
            //메인사이드바 항목 줄이기
            mainSidebarBody.classList.add("adj-body-sidebar-main--close");
            //서브사이드바 조절
            subSidebarWrapper.classList.remove("adj-sidebar-sub--close");
            subSidebarWrapper.classList.add("adj-sidebar-sub--open");

            //서브사이드바 내부 항목 열기
            document.getElementById(exchange_clickableToInnerbody(openedElementId)).classList.add("adj-sidebar-sub-ele--open");
        } else {
            //열려있음 - 열린놈이 클릭되었는지 다른 놈이 클릭되었는지 체크
            if(openedElementId != event.target.id) {
                //다른놈이 클릭됨 - 서브 사이드바만 교체
                document.getElementById(exchange_clickableToInnerbody(openedElementId)).classList.remove("adj-sidebar-sub-ele--open");
                document.getElementById(exchange_clickableToInnerbody(event.target.id)).classList.add("adj-sidebar-sub-ele--open");
                //열린항목 id 갱신
                openedElementId = event.target.id;
            } else {
                //같은놈 클릭시 메인을 열고 서브를 닫아준다
                //메인사이드바 조절
                mainSidebarWrapper.classList.remove("adj-sidebar-main--close");
                mainSidebarWrapper.classList.add("adj-sidebar-main--open");
                //메인사이드바 항목 원복
                mainSidebarBody.classList.remove("adj-body-sidebar-main--close");
                //서브사이드바 조절
                subSidebarWrapper.classList.remove("adj-sidebar-sub--open");
                subSidebarWrapper.classList.add("adj-sidebar-sub--close");
                //서브사이드바 내부항목 숨기기
                document.getElementById(exchange_clickableToInnerbody(openedElementId)).classList.remove("adj-sidebar-sub-ele--open");
                //열린항목 id 리셋
                openedElementId = null;
            }
        }
    });
});

//clickable-*-main 을 innerbody-*-sub 로 바꿔주는 함수
function exchange_clickableToInnerbody(clickableId) {
    return "innerbody-" + clickableId.split("-")[1] + "-sub";
}