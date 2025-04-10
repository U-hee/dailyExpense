const deleteButton = document.getElementById('delete-btn');
const modifyButton = document.getElementById('modify-btn');
const createButton = document.getElementById('create-btn');

if(deleteButton) {
    deleteButton.addEventListener('click', event => {
    let id = document.getElementById('expense-id').value;
    fetch(`/api/expenses/${id}`, {
        method: 'DELETE'
        })
        .then(() => {
            alert('삭제가 완료되었습니다.');
            location.replace('/expenses');

        });
    });
}

if(modifyButton) {
    modifyButton.addEventListener('click', event => {
    let params = new URLSearchParams(location.search);
    let id = params.get('id');

    fetch(`/api/expenses/${id}`, {
        method: 'PUT',
        headers: {
            "Content-type": "application/json",
        },
        body:JSON.stringify({
            title: document.getElementById('title').value,
            content: document.getElementById('content').value
            })
        })
        .then(() => {
            alert('수정이 완료되었습니다.');
            location.replace(`/expenses/${id}`);
        });
    });
}

if(createButton) {
    createButton.addEventListener('click', event => {
    fetch("/api/expenses", {
        method: 'POST',
        headers: {
            "Content-type": "application/json",
        },
        body:JSON.stringify({
            title: document.getElementById('title').value,
            content: document.getElementById('content').value
            })
        })
        .then(() => {
            alert('등록이 완료되었습니다.');
            location.replace("/expenses");
        });
    });
}