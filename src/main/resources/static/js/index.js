function getPosts() {
    $.ajax({
               url : `/api/v1/posts?page=${page.req.number - 1}&size=${page.req.size}`,
               type: 'GET'
           }
    ).done(res => {
               page.setData(res);
               page.render();
           }
    ).fail(err => {
        console.error(err);
    });


}

$(() => {
    // page.renderTarget = $('#post-table').find('tbody');
    // page.renderFn = (post) => {
    //     return `<tr>
    //                 <td name="post_id">
    //                     <a href="/post/${post.id}" >${post.id}</a>
    //                 </td>
    //                 <td name="post_title"                  >${post.title}</td>
    //                 <td name="post_content"                >${post.content}</td>
    //                 <td name="post_author"                 >${post.author}</td>
    //                 <td><button class="btn btn-danger" name="post_del_btn" data-id="${post.id}">delete</button></td>
    //             </tr>`
    // }
    // getPosts();

    $('#btn_new').on('click', (e) => {
        location.href = '/new';
    });
    $(document).on('click', '[name=post_del_btn]', (e) => {
        let postId = $(e.target).data('id');

        if (confirm('해당 게시글을 삭제하시겠습니까?')) {
            $.ajax({
                       url : '/api/v1/post/' + postId,
                       type: 'delete'
                   }
            ).done(res => {
                console.log(res);
                alert('삭제가 완료되었습니다.');
                location.reload();
            })
        }
    });

})
