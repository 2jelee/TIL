# Kendo UI # 
### Kendo UI for jQuery ###

1. TreeView
2. DatePicker

-----------------------
## 1. TreeView ##
jQuery TreeView 구성 요소용 Kendo UI는 계층적 데이터를 트리 구조로 나타냅니다. 
이를 통해 사용자는 단일 또는 다중 항목 선택, TreeView 내 및 Kendo UI TreeView 구성 요소 전반에 걸쳐 요소를 끌어다 놓을 수 있습니다. <br/>
checkbox support, keyboard navigation, RTL support, accessibility and provides templates for complate customization of each node를 제공합니다.
TreeView를 다양한 데이터 소스에 바인딩하고 요청 시 로드 기능을 활용하고 노드가 확장된 경우에만 데이터를 요청할 수 있습니다.
(드래그 앤 드롭 기능을 사용하여 재정렬 작업을 수행하기 위해 마우스 또는 터치 이벤트를 통한 사용자 상호 작용을 지원.)
<br/>
즉, 맵 형식의 데이터를 트리형식으로 시각화 해주는 기능.
<br/>
※node
<br/>
※RTL : Register Transfer Level<br/>
이름 그대로 register transfer가 이루어지는 Level을 추상화 한 것이기 때문에 대부분의 기술 내용이란 것이 어떤 Logic 상태의 변동을 register에 기록했다가 다음에 꺼내서 또 바꾸고 하는 일들의 연속이 됨.<br/>
일반 프로그래밍 언어인 경우 그것이 program counter에 따라 순차적으로 동작하는 개념을 가지고 있어서 윗줄에 기술된 내용이 먼저 실행되는 개념이라 보면, RTL의 경우는 그와 상관없이 동시에 일어나는 것이라고 보면 되는데 여기에 assignment(= 또는 <=)가 연관되면 개념의 혼동이 일어남.

-----------------------
### 1.1 OverView ###
![image](https://user-images.githubusercontent.com/82863823/137049631-30d82166-77f9-46ba-94af-d9129ae21210.png)

```
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="styles/kendo.common.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.mobile.min.css" />

    <script src="js/jquery.min.js"></script>
    
    
    <script src="js/kendo.all.min.js"></script>
    
    

</head>
<body>
    <div id="example">
    <div class="demo-section wide k-content">
        <div id="demo-section-title" class="treeview-flex">
            <div>
                <h3>
                    Select nodes, folders and drag them between the TreeViews
                </h3>
            </div>
        </div>
        <div class="treeview-flex">
            <div id="treeview-kendo"></div>
        </div>
        <div class="treeview-flex">
            <div>
                <h4>Drag and Drop</h4>
            </div>
        </div>
        <div class="treeview-flex">
            <div id="treeview-telerik"></div>
        </div>
    </div>
    <script id="treeview" type="text/kendo-ui-template">

        # if (!item.items && item.spriteCssClass) { #
        #: item.text #
        <span class='k-icon k-i-close kendo-icon'></span>
        # } else if(!item.items && !item.spriteCssClass) { #
        <span class="k-sprite pdf"></span>
        #: item.text #
        <span class='k-icon k-i-close telerik-icon'></span>
        # } else if (item.items && item.spriteCssClass){ #
        #: item.text #
        # } else { #
        <span class="k-sprite folder"></span>
        #: item.text #
        # } #
    </script>

    <script>
        $("#treeview-kendo").kendoTreeView({
            template: kendo.template($("#treeview").html()),
            dataSource: [{
                id: 1, text: "My Documents", expanded: true, spriteCssClass: "rootfolder", items: [
                    {
                        id: 2, text: "Kendo UI Project", expanded: true, spriteCssClass: "folder", items: [
                            { id: 3, text: "about.html", spriteCssClass: "html" },
                            { id: 4, text: "index.html", spriteCssClass: "html" },
                            { id: 5, text: "logo.png", spriteCssClass: "image" }
                        ]
                    },
                    {
                        id: 6, text: "Reports", expanded: true, spriteCssClass: "folder", items: [
                            { id: 7, text: "February.pdf", spriteCssClass: "pdf" },
                            { id: 8, text: "March.pdf", spriteCssClass: "pdf" },
                            { id: 9, text: "April.pdf", spriteCssClass: "pdf" }
                        ]
                    }
                ]
            }],
            dragAndDrop: true,
            checkboxes: {
                checkChildren: true
            },
            loadOnDemand: true
        });

        $("#treeview-telerik").kendoTreeView({
            template: kendo.template($("#treeview").html()),
            dataSource: [{
                id: 1, text: "My Documents", expanded: true, items: [
                    {
                        id: 2, text: "New Web Site", expanded: true, items: [
                            { id: 3, text: "mockup.pdf" },
                            { id: 4, text: "Research.pdf" },
                        ]
                    },
                    {
                        id: 5, text: "Reports", expanded: true, items: [
                            { id: 6, text: "May.pdf" },
                            { id: 7, text: "June.pdf" },
                            { id: 8, text: "July.pdf" }
                        ]
                    }
                ]
            }],
            dragAndDrop: true,
            checkboxes: true,
            loadOnDemand: true
        });
        // Delete button behavior
        $(document).on("click", ".kendo-icon", function (e) {
            e.preventDefault();
            var treeview = $("#treeview-kendo").data("kendoTreeView");
            treeview.remove($(this).closest(".k-item"));
        });
        $(document).on("click", ".telerik-icon", function (e) {
            e.preventDefault();
            var treeview = $("#treeview-telerik").data("kendoTreeView");
            treeview.remove($(this).closest(".k-item"));
        });
    </script>
    <style>
        @media screen and (max-width: 680px) {
            .treeview-flex {
                flex: auto !important;
                width: 100%;
            }
        }

        #demo-section-title h3 {
            margin-bottom: 2em;
            text-align: center;
        }

        .treeview-flex h4 {
            color: #656565;
            margin-bottom: 1em;
            text-align: center;
        }

        #demo-section-title {
            width: 100%;
            flex: auto;
        }

        .treeview-flex {
            flex: 1;
            -ms-flex: 1 0 auto;
        }

        .k-treeview {
            max-width: 240px;
            margin: 0 auto;
        }

        #treeview-kendo .k-sprite {
            background-image: url("../content/web/treeview/coloricons-sprite.png");
        }

        #treeview-telerik .k-sprite {
            background-image: url("../content/web/treeview/coloricons-sprite.png");
        }

        .demo-section {
            margin-bottom: 5px;
            overflow: auto;
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap;
        }

        .rootfolder {
            background-position: 0 0;
        }

        .folder {
            background-position: 0 -16px;
        }

        .pdf {
            background-position: 0 -32px;
        }

        .html {
            background-position: 0 -48px;
        }

        .image {
            background-position: 0 -64px;
        }

    </style>
</div>

</body>
</html>

```
-------------------------
### 1.2 Basic usage ###
![image](https://user-images.githubusercontent.com/82863823/137050005-0ce9521b-4604-4296-9d26-8123fee342dc.png)

```
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="styles/kendo.common.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.mobile.min.css" />

    <script src="js/jquery.min.js"></script>
    
    
    <script src="js/kendo.all.min.js"></script>
    
    

</head>
<body>
    
<div id="example">
    <div class="demo-section k-content">
        <ul id="treeview">
            <li data-expanded="true">
                <span class="k-sprite folder"></span>
                My Web Site
                <ul>
                    <li data-expanded="true">
                        <span class="k-sprite folder"></span>images
                        <ul>
                            <li><span class="k-sprite image"></span>logo.png</li>
                            <li><span class="k-sprite image"></span>body-back.png</li>
                            <li><span class="k-sprite image"></span>my-photo.jpg</li>
                        </ul>
                    </li>
                    <li data-expanded="true">
                        <span class="k-sprite folder"></span>resources
                        <ul>
                            <li data-expanded="true">
                                <span class="k-sprite folder"></span>pdf
                                <ul>
                                    <li><span class="k-sprite pdf"></span>brochure.pdf</li>
                                    <li><span class="k-sprite pdf"></span>prices.pdf</li>
                                </ul>
                            </li>
                            <li><span class="k-sprite folder"></span>zip</li>
                        </ul>
                    </li>
                    <li><span class="k-sprite html"></span>about.html</li>
                    <li><span class="k-sprite html"></span>contacts.html</li>
                    <li><span class="k-sprite html"></span>index.html</li>
                    <li><span class="k-sprite html"></span>portfolio.html</li>
                </ul>
            </li>
        </ul>
    </div>

    <script>$(document).ready(function() {
                    $("#treeview").kendoTreeView();
                });</script>

    <style>

        #treeview .k-sprite {
            background-image: url("../content/web/treeview/coloricons-sprite.png");
        }

        .rootfolder {
            background-position: 0 0;
        }

        .folder {
            background-position: 0 -16px;
        }

        .pdf {
            background-position: 0 -32px;
        }

        .html {
            background-position: 0 -48px;
        }

        .image {
            background-position: 0 -64px;
        }
    </style>
</div>

</body>
</html>
```

--------------------------------------

## Functionality ##
### (1) Drag & drop ###
![image](https://user-images.githubusercontent.com/82863823/137052430-7ea74942-b954-4d37-9c8f-43a8133ca3a1.png)

```
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="styles/kendo.common.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.mobile.min.css" />

    <script src="js/jquery.min.js"></script>
    
    
    <script src="js/kendo.all.min.js"></script>
    
    

</head>
<body>
    <div id="example">
    <div class="demo-section k-content">
        <div>
            <h4>Treeview One</h4>
            <div id="treeview-left"></div>
        </div>
        <div>
            <h4>Treeview Two</h4>
            <div id="treeview-right"></div>
        </div>
    </div>

    <script>
        $("#treeview-left").kendoTreeView({
            dragAndDrop: true,
            dataSource: [
                { text: "Furniture", expanded: true, items: [
                    { text: "Tables & Chairs" },
                    { text: "Sofas" },
                    { text: "Occasional Furniture" }
                ] },
                { text: "Decor", items: [
                    { text: "Bed Linen" },
                    { text: "Curtains & Blinds" },
                    { text: "Carpets" }
                ] }
            ]
        });

        $("#treeview-right").kendoTreeView({
            dragAndDrop: true,
            dataSource: [
                { text: "Storage", expanded: true, items: [
                    { text: "Wall Shelving" },
                    { text: "Floor Shelving" },
                    { text: "Kids Storage" }
                ]
                },
                { text: "Lights", items: [
                    { text: "Ceiling" },
                    { text: "Table" },
                    { text: "Floor" }
                ]
                }
            ]
        });
    </script>

    <style>
        .demo-section{
            display:flex;
            justify-content:space-evenly;
        }
    </style>
</div>

</body>
</html>
```
dragAndDrop : false : Disable / true : enables <br/>
dataSources : [{text}]에 text를 추가할 경우 node가 생성됨을 확인

-----------------------
### (2) Animation effects ###
Animation Settings : toggle animation / expand animation
![image](https://user-images.githubusercontent.com/82863823/137052300-b518cb0b-af5d-4edf-9567-b05e2bd88d50.png)

-----------------------
### (3) Images ###
![image](https://user-images.githubusercontent.com/82863823/137051583-da61f5fc-ad68-44b0-a934-f6f33ceaaec6.png)

-----------------------
### (4) Checkboxes ###
![image](https://user-images.githubusercontent.com/82863823/137051613-e52c7913-06aa-448c-838e-6c2596904e54.png)

-----------------------
### (5) Filter TreeView in dialog ###
![image](https://user-images.githubusercontent.com/82863823/137051641-0d043f05-b4ef-46c8-92c3-24f1ec90a9c9.png)

-----------------------
### (6) Templates ###
![image](https://user-images.githubusercontent.com/82863823/137051668-42db5901-a047-4302-a4d7-99e6da02229a.png)

---------------------------
## Data Binding ##
### (1) Binding to local data ###
### (2) Binding to remote data ###
### (3) Binding to OData service ###

## API ##
### Events ###
### API ###





1. treeView에서 노드가 선택될 때 






----------------------- 
## 2. DatePicker ##
demo는 사용자가 캘린더에서 날짜를 손쉽게 편집하고 선택할 수 있는 방법을 보여줍니다. 웹 애플리케이션용 jQuery DatePicker 위젯에서 날짜 편집 기능과 애니메이션 dropdown을 결합합니다.
R2 2017부터 DatePicker는 DateInput을 기본 입력으로 사용할 수 있습니다. 예제의 두 번째 DatePicker는 DateInput을 사용하도록 구성되어 있습니다.

------------- 
### 2.1 Basic usage ###
![image](https://user-images.githubusercontent.com/82863823/137054596-5f4a598a-efbf-45d8-af36-816a21c32d20.png)

```
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="styles/kendo.common.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.mobile.min.css" />

    <script src="js/jquery.min.js"></script>
    
    
    <script src="js/kendo.all.min.js"></script>
    
    

</head>
<body>
    
        <div id="example">
            <div class="demo-section k-content">

                <h4>Show e-mails from:</h4>
                <input id="datepicker" value="10/10/2011" title="datepicker" style="width: 100%" />

                <h4 style="margin-top: 2em;">Add to archive mail from:</h4>
                <input id="monthpicker" value="November 2011" title="monthpicker" style="width: 100%" />
            </div>
        <script>
            $(document).ready(function() {
                // create DatePicker from input HTML element
                $("#datepicker").kendoDatePicker();

                $("#monthpicker").kendoDatePicker({
                    // defines the start view
                    start: "year",

                    // defines when the calendar should return date
                    depth: "year",

                    // display month and year in the input
                    format: "MMMM yyyy",

                    // specifies that DateInput is used for masking the input element
                    dateInput: true
                });
            });
        </script>
        </div>

</body>
</html>
```

input태그를 통해 설정된 값을 확인. <br/>
script태그 하위의 start, depth, format의 값을 변경할 경우 반영됨을 확인할 수 있다. 

------------- 
### 2.1 Basic usage ###
------------- 
### 2.2 Component Type ### 
R2 2020부터 jQuery용 Kendo UI DatePicker 는 렌더링 업데이트와 위젯의 새로운 모양을 도입합니다. 위젯의 새로운 모양과 느낌으로 전환하는 것은 componentType 속성을 "modern" 으로 설정하는 것만큼 간단합니다. <br/>
선택기 아래의 DropDownList는 구성 요소 유형을 즉석에서 전환하고 현대적 모양과 고전적 모양의 차이점을 관찰할 수 있는 기회를 제공합니다.
![image](https://user-images.githubusercontent.com/82863823/137066718-eb794965-37a3-4ad2-a037-74f99a95b3fd.png)

```
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="styles/kendo.common.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.mobile.min.css" />

    <script src="js/jquery.min.js"></script>
    
    
    <script src="js/kendo.all.min.js"></script>
    
    

</head>
<body>
    <div id="example">
    <div class="demo-section k-content">
        <h4>Select Date:</h4>
        <div>
            <input id="datepicker" value="10/10/2011" title="datepicker" style="width: 100%" />
        </div>
    </div>
    <div class="box">
        <div class="box-col">
            <h4>Set component  type</h4>
            <input id="dropDownList" />
        </div>
    </div>
    <script>
        $(document).ready(function () {
            $("#datepicker").kendoDatePicker({
                componentType: "modern"
            });

            $("#dropDownList").kendoDropDownList({
                dataSource: ["modern", "classic"],
                value: "modern",
                change: function (e) {
                    var picker = $("#datepicker").data("kendoDatePicker");
                    var type = this.value();
                    var parent = $("#datepicker").parent()

                    picker.destroy();
                    parent.empty();
                    parent.append('<input id="datepicker" value="10/10/2011" title="datepicker" style="width: 100%" />');
                    $("#datepicker").kendoDatePicker({
                        componentType: type
                    });
                }
            });
        });
    </script>
</div>

</body>
</html>
```
###### Set component type ######
mordern <br/>
classic

------------- 
### 2.3 Range selection ###
------------- 
### 2.4 Customizing templates ###
------------- 
### 2.5 Events ###
------------- 
### 2.6 Disable dates ###
------------- 
### 2.7 Week Column ###
------------- <br/>
###### Edit. markup language ######
