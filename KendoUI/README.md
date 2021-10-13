# Kendo UI # 
### Kendo UI for jQuery ###

1. TreeView
2. DatePicker

-----------------------
## TreeView ##
맵 형식의 데이터를 트리형식으로 시각화 해주는 기능.

# TreeView #
### - OverView ###
jQuery TreeView 구성 요소용 Kendo UI는 계층적 데이터를 트리 구조로 나타냅니다. 
이를 통해 사용자는 단일 또는 다중 항목 선택, TreeView 내 및 Kendo UI TreeView 구성 요소 전반에 걸쳐 요소를 끌어다 놓을 수 있습니다. 
기본 제공 확인란 지원, 키보드 탐색, RTL 지원, 접근성과 함께 제공되며 각 노드의 완전한 사용자 지정을 위한 템플릿을 제공합니다. 
TreeView를 다양한 데이터 소스에 바인딩하고 요청 시 로드 기능을 활용하고 노드가 확장된 경우에만 데이터를 요청할 수 있습니다.
  드래그 앤 드롭 기능을 사용하여 재정렬 작업을 수행하기 위해 마우스 또는 터치 이벤트를 통한 사용자 상호 작용을 지원.
*node

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

### - Basic usage ###
### - MVVM ###

## Functionality ##
### - Drag & drop ###
### - Animation effects ###
### - Images ###
### - Checkboxes ###
### - Filter TreeView in dialog ###
### - Templates ###

## Data Binding ##
### Binding to local data ###
### Binding to remote data ###
### Binding to OData service ###

## API ##
### Events ###
### API ###





1. treeView에서 노드가 선택될 때 

###### Edit. markup language ######
