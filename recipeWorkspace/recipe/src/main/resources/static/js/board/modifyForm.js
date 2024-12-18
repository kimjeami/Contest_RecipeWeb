// 재료 추가
function addThings() {
    var container = document.getElementById('things_container'); // `things_container` 요소를 가져옵니다.
    var newRow = document.createElement('div'); // 새로운 div 생성

    newRow.innerHTML = `
        <label><input type="text" name="things_name[]"/></label>
        <label><input type="text" name="ea[]"/></label>
        <label><input type="text" name="things_url[]"/></label>
        <button type="button" onclick="removeElement(this)">삭제</button>
    `;

    container.appendChild(newRow); // `things_container`의 마지막에 새 항목을 추가합니다.
}


// 요리 순서 추가
function addRecipe() {
    var container = document.getElementById('recipe_container'); // `recipe_container` 요소를 가져옵니다.
    var newStep = document.createElement('div'); // 새로운 div 생성

    newStep.className = 'recipe_step'; // 클래스 이름 추가

    newStep.innerHTML = `
        <textarea rows="5" name="explanation[]"></textarea>
        <input type="file" name="recipe_seq_img[]" onchange="readURL(this, 'preview_new')"/>
        <input type="hidden" name="existingRecipeSeqImg" value="">
        <img src="" id="preview_new" width="200px" height="200px" data-default="">
        <br>
        <button type="button" onclick="removeElement(this)">삭제</button>
        <br/><br/>
    `;

    container.appendChild(newStep); // `recipe_container`의 마지막에 새 항목을 추가합니다.
}


// 요소 삭제
function removeElement(button) {
    button.parentElement.remove();
}



// 필수 항목 입력 체크
function RecipeCheck() {
    if(document.modifyForm.title.value=="") {
    		alert("제목은 필수 입력입니다.");
    		document.modifyForm.title.focus();
    	}
     else if(document.modifyForm.introduce.value=="") {
                 		alert("소개는 필수 입력입니다.");
                 		document.modifyForm.introduce.focus();
         }
      else if(document.modifyForm.recipe_cate_no.value=="") {
                  		alert("카테고리를 선택해주세요.");
                  		document.modifyForm.recipe_cate_no.focus();
              }
    else if(document.modifyForm.serving.value=="") {
             		alert("인분은 필수 입력입니다.");
             		document.modifyForm.serving.focus();
         }
     else if(document.modifyForm.time_taken.value=="") {
                 		alert("시간은 필수 입력입니다.");
                 		document.modifyForm.time_taken.focus();
             }
      else if(document.modifyForm.step.value=="") {
                        alert("난이도는 필수 입력입니다.");
                        document.modifyForm.step.focus();
              }
       else if ((document.modifyForm.explanation.length > 0 && document.modifyForm.explanation[0].value == "") ||
                 (document.modifyForm.explanation.length === 0 && document.modifyForm.explanation.value == "")) {
           alert("레시피순서에 내용은 필수 입력입니다.");
           if (document.modifyForm.explanation.length > 0) {
               document.modifyForm.explanation[0].focus();
           } else {
               document.modifyForm.explanation.focus();
           }
       }

    else {
    		modifyForm.submit();
    	}
}

