# 戦術的DDDのためのフレームワークの実装

戦術的DDDを実装するための基本的な抽象を提供する

## 設計方針

Aggregate に対する変更は Aggregate Root を通して行い、別の Aggregate は Aggregate Root そのものではなく Identifier で参照する

Entity、Value Object、Identifier、Aggregate Root などの抽象を提供する

分散DB / read replica / message queue などミドルウェアが提供する機能はミドルウェアへ委譲する。

## 永続化モデル

データをSnapshotModelとして永続化するStateSourcingな設計を実装対象とする

ここではEvent Sourcingは、snapshotの更新では必要なwriteスループットを満たせず、Read Modelへの反映が結果整合でも許容できる場合の設計手法だと整理する

履歴、監査、時間軸に沿った状態の参照が必要な場合は、Bi-temporal Data Modelingなどの別の永続化モデルの拡張によって扱うことを想定する

本フレームワークでは、RDBのread replicaや分散DBによって必要なread/write性能を確保できるシステムを想定しているため、Event Sourcingを実装対象としない

## 非同期処理

APIでのCSV入稿の受付とdaemonでの取込処理を分離するような本質的に非同期な処理では、アプリケーション内部でデータを持たず外部のMessage QueueとPublisher／Subscriberを利用する。
