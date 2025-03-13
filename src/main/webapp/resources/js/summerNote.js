
    
      $('#detail').summernote({

        height : 300,
        callbacks:{
            onImageUpload: function(files){
                console.log(files[0]); //<input type="file">
                let f = new FormData();
                f.append("uploadFile", files[0]);

                fetch("./detailFiles", {
                    method: 'POST',
                    body: f
                })
                .then(r => r.text())
                .then(r => {
                    $('#detail').summernote('editor.insertImage', r.trim());
                })
                
            },

            // 기다리라는 뜻의 await를 밑에서 쓰려면 함수 선언부에 async를 써야한다.
            onMediaDelete:  (files) => {
                // js : getAttribute(), 속성명
                // jquery : attr("속성명"), prop("속성명")
                console.log(files[0])
                console.log(files[0].src)

                let fileName1 = files[0].src;
                let fileName = fileName1.split("/");
                console.log(fileName[fileName.length-1]);

                fileName = fileName1.substring(fileName1.lastIndexOf("/")+1);
                console.log(fileName);

                
                //
                let f = new FormData();
                f.append("fileName", fileName)

                let result =  fetch("./detailFilesDelete", {
                    method: 'POST',
                    // headers : {
                    //     "Content-type" : "application/x-www-form-urlencoded; charset=UTF-8"
                    // },
                    // body: `fileName=${fileName}`
                    body: f
                });

                console.log(result);


            }

        }
        
      })
    