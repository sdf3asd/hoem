  $(document).ready(function () {
        $("#cards-box").empty();
        $.ajax({
          type: "GET",
          url: "http://openapi.seoul.go.kr:8088/6f6f5a416c776572353369766d6875/json/TbPublicWifiInfo/1/20/", //사용자가 가져온 API를 넣으세요
          data: {},
          success: function (response) {
            let article = response["articles"];
            for (let i = 0; i < article.length; i++) {
              let title = article[i]["title"];
              let comment = article[i]["comment"];
              let image_url = article[i]["image"];
              let movie_url = article[i]["url"];
              let desc = article[i]["desc"];

              let temp_html = `<div class="card">
                                    <img
                                        class="card-img-top"
                                        src="${image_url}"
                                        alt="Card image cap"
                                    />
                                    <div class="card-body">
                                        <a href="${movie_url}"
                                        >${title}</a
                                        >
                                        <p class="card-text">
                                        ${desc}
                                        </p>
                                        <p class="card-text comment">${comment}</p>
                                    </div>
                                </div>`;

              $("#cards-box").append(temp_html);
            }
          },
        });
      });
