// 재료 추가
function addThings() {
    var container = document.getElementById('things_container');
    var newRow = document.createElement('div');

    newRow.innerHTML = `
        <label><input type="text" name="things_name[]"/></label>
        <label><input type="text" name="ea[]"/></label>
        <label><input type="text" name="things_url[]"/></label>
        <button type="button" onclick="removeElement(this)">삭제</button>
    `;

    container.appendChild(newRow);
}

// 요리 순서 추가
function addRecipe() {
    var container = document.getElementById('recipe-container');
    var newRow = document.createElement('div');

    newRow.innerHTML = `
        <textarea rows="5" placeholder="내용을 입력하세요" name="explanation[]" ></textarea>
        <input type="file" name="recipe_seq_img[]"/>
        <button type="button" onclick="removeElement(this)">삭제</button>
    `;

    container.appendChild(newRow);
}

// 요소 삭제
function removeElement(button) {
    button.parentElement.remove();
}


// 필수 항목 입력 체크
function RecipeCheck() {
    if(document.boardWriteForm.title.value=="") {
    		alert("제목은 필수 입력입니다.");
    		document.boardWriteForm.title.focus();
    	}
     else if(document.boardWriteForm.introduce.value=="") {
                 		alert("소개는 필수 입력입니다.");
                 		document.boardWriteForm.introduce.focus();
         }
      else if(document.boardWriteForm.recipe_cate_no.value=="") {
                  		alert("카테고리를 선택해주세요.");
                  		document.boardWriteForm.recipe_cate_no.focus();
              }
    else if(document.boardWriteForm.serving.value=="") {
             		alert("인분은 필수 입력입니다.");
             		document.boardWriteForm.serving.focus();
         }
     else if(document.boardWriteForm.time_taken.value=="") {
                 		alert("시간은 필수 입력입니다.");
                 		document.boardWriteForm.time_taken.focus();
             }
      else if(document.boardWriteForm.step.value=="") {
                        alert("난이도는 필수 입력입니다.");
                        document.boardWriteForm.step.focus();
              }
       else if(document.boardWriteForm.explanation.value=="") {
                        alert("레시피순서에 내용은 필수 입력입니다.");
                        document.boardWriteForm.explanation.focus();
          }



    else {
    		boardWriteForm.submit();
    	}
}

