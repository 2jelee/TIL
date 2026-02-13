import { Form } from "remix";
/* User -> Server */

export async function action({request}){
  let data = await request.formData();
  console.log(data.get('name'));
  console.log(data.get('age'));
  return null; // <- 수신 완료 시 유저에게 응답 가능!
}

export default function Index() {
  return (
    <div>
      <h1>Welcome to Remix</h1>
      <Form action="" method="post">
        <input type="text" name="name"/>
        <input type="text" name="age"/>
        <button type="submit">전송</button>
      </Form>
    </div> //사용자가 적은 form이 자동으로 전송된다. JS 필요 X
  );
}
