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
        <textarea rows="5" placeholder="내용을 입력하세요" name="explanation[]"></textarea>
        <input type="file" name="recipe_seq_img[]"/>
        <button type="button" onclick="removeElement(this)">삭제</button>
    `;

    container.appendChild(newRow);
}

// 요소 삭제
function removeElement(button) {
    button.parentElement.remove();
}
