document.getElementById('delBtn').addEventListener('click',()=>{
    document.getElementById('delForm').submit();    // onsubmit() 아님
});

function moveList(){
    try {
        const url = '/board/list';
        
    } catch (error) {
        console.log(error);
    }
}

document.getElementById('listBtn').addEventListener('click',()=>{
    const delForm = document.getElementById('delForm');
    delForm.bno.remove();   // delForm 안의 hidden 지움 > 주소창에 list?하고 bno가 들어오기 때문에 > ?붙는것도 싫으면 location href/replace 를 쓰면 된다.
    delForm.setAttribute('action', '/board/list');
    delForm.setAttribute('method', 'get');
    delForm.submit();

    // location.href = "/board/list";
    // location.replace("/board/list");
});

document.getElementById('modBtn').addEventListener('click',()=>{
    document.getElementById('title').readOnly = false;
    document.getElementById('content').readOnly = false;

    let modBtn = document.createElement('button');
    modBtn.setAttribute('type', 'submit');
    modBtn.classList.add('btn', 'btn-warning');
    modBtn.innerText = "Submit";

    document.querySelector("#modForm").appendChild(modBtn);
    document.getElementById('modBtn').remove();
    document.getElementById('delBtn').remove();
});