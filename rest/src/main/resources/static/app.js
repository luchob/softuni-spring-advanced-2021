$('#loadAuthors').click(() => {
  $('.authors-container').empty();
  $('.books-container').empty();

  fetch('http://localhost:8080/authors').
      then((response) => response.json()).
      then((json) => json.forEach((author, idx) => {
        console.log(author.name);

        let tableRow = '<tr>' +
            '<td>' + author.id + '</td>' +
            '<td>' + author.name + '</td>' +
            '<td><button class="book-btn" data-author-id="' + author.id+ '">Show books</button></td>' +
            '<td><button>Delete</button></td>' +
            '</tr>'
      $('.authors-container').append(tableRow);
  }))
});

$('body').on('click', 'button.book-btn', function() {
  let authorId = $(this).data('author-id');
  console.log("Author Id is " + authorId);

  $('.books-container').empty();

  fetch('http://localhost:8080/authors/'+authorId+'/books').
    then((response) => response.json()).
    then((json) => json.forEach((book, idx)=> {
      console.log(book.title);

      let tableRow =
          '<tr>' +
          '<td>' + book.title + '</td>' +
          '<td><button>Delete book</button></td>' +
          '</tr>';

      $('.books-container').append(tableRow);
  }))
})
