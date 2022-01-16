export let loader = function () {
  //DB에서 데이터 뽑아주세요! 작성하는 곳
  return [{name : "Pants"}, {name : "Jacket"}]; // return에 DB데이터 뽑아서 여기에 담으면 된다.
};

import { useLoaderData } from "remix";

export default function Index() {
  let data = useLoaderData();
  return (
    <div>
      <h1>Welcome to Remix {data}</h1>
    </div>
  );
}
