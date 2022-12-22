
function getPosts () {
    const $tableBody = $('#post-table').find('tbody');
    $.ajax({
        url: '/api/v1/posts',
        type: 'GET',
        data : {},
    }).done(res => {
        let html = "";
        res.forEach(post => {
            html += `
                <tr>
                    <td name="post_id">
                        <a href="/post/${post.id}" >${post.id}</a>
                    </td>
                    <td name="post_title"                  >${post.title}</td>
                    <td name="post_content"                >${post.content}</td>
                    <td name="post_author"                 >${post.author}</td>
                    <td><button name="post_del_btn" data-id="${post.id}">delete</button></td>
                </tr>
            `;
        });
        $tableBody.html(html);
    }).fail(err => {
        console.error(err);
    });
}

$(() => {
    getPosts();

    $('#btn_new').on('click', (e) => {
        location.href = "/new";
    });

    $(document).on('click','[name=post_del_btn]',(e) => {
        let postId = $(e.target).data("id");

        if( confirm('해당 게시글을 삭제하시겠습니까?') ){
            $.ajax({
                url: '/api/v1/post/' + postId,
                type: 'delete',
            }).done(res => {
                alert('삭제가 완료되었습니다.');
                location.reload();
            })
        }
    });

})