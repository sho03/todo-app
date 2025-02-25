/**
 * 外部への通信を行うポートを定義する.
 * 主にデータベース層へのアクセス（アプリケーションから外部への送信）
 * 他に、例えば外部のAPIを呼び出す際にも使用する.
 * 実際のところ、データベースに対する操作ごとにインターフェースを分けるほうが良いかもしれないがそこはよくわかっていない（アプリケーションの規模にもよる？）
 */
package com.sho03.todo.port.out;